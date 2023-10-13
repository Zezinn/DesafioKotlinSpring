package service

import model.Marca
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import repository.MarcaRepository
import java.util.Optional

@Service
class MarcaService {

    @Autowired
    private lateinit var marcaRepository: MarcaRepository

    fun getAllMarcas(): List<Marca> {
        return marcaRepository.findAll()
    }

    fun getMarcaById(id: Long): Optional<Marca> {
        return marcaRepository.findById(id)
    }

    fun createMarca(marca: Marca): Marca {
        return marcaRepository.save(marca)
    }

    fun updateMarca(id: Long, updatedMarca: Marca): Optional<Marca> {
        if (marcaRepository.existsById(id)) {
            updatedMarca.id = id
            return Optional.of(marcaRepository.save(updatedMarca))
        } else {
            return Optional.empty()
        }
    }

    fun deleteMarca(id: Long): Boolean {
        if (marcaRepository.existsById(id)) {
            marcaRepository.deleteById(id)
            return true
        } else {
            return false
        }
    }
}