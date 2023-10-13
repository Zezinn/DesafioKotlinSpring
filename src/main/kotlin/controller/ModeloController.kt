package controller


import service.ModeloService
import model.Modelo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/modelos")
class ModeloController (@Autowired private val modeloService: ModeloService) {

    @PostMapping
    fun createModelo(@RequestBody modelo: Modelo): ResponseEntity<Modelo> {
        val createModelo = modeloService.createModelo(modelo)
        return ResponseEntity.status(HttpStatus.CREATED).body(createModelo)
    }

    @GetMapping("/{id}")
    fun getModeloById(@PathVariable id: Long): ResponseEntity<Modelo> {
        val modelo = modeloService.getModeloById(id)
        return modelo.map { ResponseEntity.ok(it) }
                .orElseGet { ResponseEntity.notFound().build() }
    }

    @GetMapping
    fun getAllModelos(): ResponseEntity<List<Modelo>> {
        val modelos = modeloService.getAllModelos()
        return ResponseEntity.ok(modelos)
    }

    @PutMapping("/{id}")
    fun updateModelo(@PathVariable id: Long, @RequestBody updatedModelo: Modelo): ResponseEntity<Modelo> {
        val updatedModelo = modeloService.updateModelo(id, updatedModelo)
        return updatedModelo.map { ResponseEntity.ok(it) }
                .orElseGet { ResponseEntity.notFound().build() }
    }

    @DeleteMapping("/{id}")
    fun deleteModelo(@PathVariable id: Long): ResponseEntity<Void> {
        return if (modeloService.deleteModelo(id)) {
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
}
