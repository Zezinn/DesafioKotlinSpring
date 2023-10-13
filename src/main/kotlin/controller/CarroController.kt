package controller

import model.Carro
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.*
import service.CarroService

@RestController
@RequestMapping("/carros")
class CarroController(@Autowired private val carroService: CarroService) {
    @GetMapping("/{id}")
    fun getCarById(@PathVariable id: Long): ResponseEntity<Carro?> {
        val car = carroService.getCarById(id)
        return if (car != null) {
            ResponseEntity.ok(car)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @GetMapping
    fun getAllCars(): ResponseEntity<List<Carro>> {
        val cars = carroService.getAllCars()
        return ResponseEntity.ok(cars)
    }

    @PostMapping
    fun createCar(@RequestBody car: Carro): ResponseEntity<Carro> {
        val createCarro = carroService.createCarro(car)
        return ResponseEntity.status(HttpStatus.CREATED).body(createCarro)
    }

    @PutMapping("/{id}")
    fun updateCarro(@PathVariable id: Long, @RequestBody updatedCarro: Carro): ResponseEntity<Carro?> {
        val updatedCar = carroService.updateCarro(id, updatedCarro)
        return if (updatedCar != null) {
            ResponseEntity.ok(updatedCar)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @DeleteMapping("/{id}")
    fun deleteCarro(@PathVariable id: Long): ResponseEntity<Void> {
        val car = carroService.getCarById(id)
        if (car != null) {
            carroService.deleteCarro(id)
            return ResponseEntity.noContent().build()
        }
        return ResponseEntity.notFound().build()
    }
}
