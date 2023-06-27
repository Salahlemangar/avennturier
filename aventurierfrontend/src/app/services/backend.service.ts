import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Coordinate } from '../models/coordinate.model';


@Injectable({
  providedIn: 'root'
})
export class BackendService {

  private baseUrl = 'http://localhost:8080'; 

  constructor(private http: HttpClient) {}

  moveCharacter(initialCoordinates: any, movements: string): Observable<Coordinate> {
    const url = `${this.baseUrl}/api/character/move`;
    const body = {
      initialCoordinates: initialCoordinates,
      movements: movements
    };

    return this.http.post<Coordinate>(url, body);
  }
}
