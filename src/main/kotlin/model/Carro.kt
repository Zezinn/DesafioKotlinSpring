package model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDateTime

@Entity
data class Carro (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,
        var timestampCadastro: LocalDateTime? = null,
        val modeloId: Long,
        val ano: Int,
        val combustivel: String,
        val numPortas: Int,
        val cor: String
)
