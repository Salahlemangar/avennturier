import { Component } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Observable } from 'rxjs';
import { BackendService } from '../../services/backend.service';
import { Coordinate } from '../../models/coordinate.model';


@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent {

  coordinates: any;
  movements: string = '';
  result?: Coordinate;
  ;

  constructor(private backendService: BackendService) {}

  onSubmit(): void {
    const initialCoordinates = {
      x: parseInt(this.coordinates.split(',')[0]),
      y: parseInt(this.coordinates.split(',')[1])
    };

    this.backendService.moveCharacter(initialCoordinates, this.movements).subscribe(
      (result) => {
        this.result = result;
      },
      (error) => {
        // Handle the error here
      }
    );
  }

}
