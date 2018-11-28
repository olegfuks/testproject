import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'search'
})
export class SearchPipe implements PipeTransform {
  transform(films, value) {
    if (films === null || films === undefined) {
      return [];
    }
    if (value === null || value === undefined) {
      return [];
    }
    return films.filter(film => {
      return film.name.toLowerCase().startsWith(value.toLowerCase());
    });
  }
}
