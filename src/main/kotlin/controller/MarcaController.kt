package controller

import model.Marca
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.*
import service.MarcaService


@RestController
@RequestMapping("/marcas")
class MarcaController(@Autowired private val marcaService: MarcaService) {

    @PostMapping
    fun createMarca(@RequestBody marca: Marca): ResponseEntity<Marca> {
        val createMarca = marcaService.createMarca(marca)
        return ResponseEntity.status(HttpStatus.CREATED).body(createMarca)
    }

    @GetMapping("/{id}")
    fun getMarcaById(@PathVariable id: Long): ResponseEntity<Marca> {
        val marca = marcaService.getMarcaById(id)
        return marca.map { ResponseEntity.ok(it) }
                .orElseGet { ResponseEntity.notFound().build() }
    }

    @GetMapping
    fun getAllMarcas(): ResponseEntity<List<Marca>> {
        val marcas = marcaService.getAllMarcas()
        return ResponseEntity.ok(marcas)
    }

    @PutMapping("/{id}")
    fun updateMarca(@PathVariable id: Long, @RequestBody updatedMarca: Marca): ResponseEntity<Marca> {
        val updatedMarca = marcaService.updateMarca(id, updatedMarca)
        return updatedMarca.map { ResponseEntity.ok(it) }
                .orElseGet { ResponseEntity.notFound().build() }
    }

    @DeleteMapping("/{id}")
    fun deleteMarca(@PathVariable id: Long): ResponseEntity<Void> {
        return if (marcaService.deleteMarca(id)) {
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
}
