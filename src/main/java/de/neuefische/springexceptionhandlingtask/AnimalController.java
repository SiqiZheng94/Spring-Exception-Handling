package de.neuefische.springexceptionhandlingtask;

import org.apache.logging.log4j.message.Message;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/animals")
public class AnimalController {

    @GetMapping("/{species}")
    String getAnimalSpecies(@PathVariable String species) {
        if (!species.equals("dog")) {
            throw new IllegalArgumentException();
        }
        return species;
    }

    @GetMapping
    String getAllAnimals() {
        throw new NoSuchElementException();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage handleException(IllegalArgumentException exception) {
        return new ErrorMessage("Only 'dog' is allowed");
    }

    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage handleException(NoSuchElementException exception) {
        return new ErrorMessage("No Animals found");
    }


}

