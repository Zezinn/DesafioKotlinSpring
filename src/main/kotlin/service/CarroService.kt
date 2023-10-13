package service

import jakarta.transaction.Transactional
import model.Carro
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import repository.CarroRepository
import repository.ModeloRepository
import java.time.LocalDateTime

@Service
class CarroService @Autowired constructor(
        private val carroRepository: CarroRepository,
        private val modeloRepository: ModeloRepository
) {
    @Transactional
    fun getAllCars(): List<Carro> = carroRepository.findAll()

    @Transactional
    fun getCarById(id: Long): Carro? = carroRepository.findById(id).orElse(null)

    @Transactional
    fun createCarro(carro: Carro): Carro {
        carro.timestampCadastro = LocalDateTime.now()
        return carroRepository.save(carro)
    }

    @Transactional
    fun updateCarro(id: Long, updatedCarro: Carro): Carro? {
        if (carroRepository.existsById(id)) {
            updatedCarro.id = id
            updatedCarro.timestampCadastro = LocalDateTime.now()
            return carroRepository.save(updatedCarro)
        }
        return null
    }

    @Transactional
    fun deleteCarro(id: Long) {
        carroRepository.deleteById(id)
    }
}
