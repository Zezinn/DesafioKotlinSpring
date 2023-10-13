package service


import model.Modelo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import repository.ModeloRepository
import java.util.Optional

@Service
class ModeloService @Autowired constructor(private val modeloRepository: ModeloRepository) {

    fun getAllModelos(): List<Modelo> {
        return modeloRepository.findAll()
    }

    fun getModeloById(id: Long): Optional<Modelo> {
        return modeloRepository.findById(id)
    }

    fun createModelo(modelo: Modelo): Modelo {
        return modeloRepository.save(modelo)
    }

    fun updateModelo(id: Long, updatedModelo: Modelo): Optional<Modelo> {
        if (modeloRepository.existsById(id)) {
            updatedModelo.id = id
            return Optional.of(modeloRepository.save(updatedModelo))
        } else {
            return Optional.empty()
        }
    }

    fun deleteModelo(id: Long): Boolean {
        if (modeloRepository.existsById(id)) {
            modeloRepository.deleteById(id)
            return true
        } else {
            return false
        }
    }
}
