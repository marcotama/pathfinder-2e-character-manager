package ai.ragu.charactermanager.pojo

import AbstractJpaPersistable
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class AbilityScore(
        @Id
        @Column(nullable = false)
        val id: String? = null,

        @Column(nullable = false)
        val name: String? = null,

        @Column(nullable = true)
        val description: String? = null
) : AbstractJpaPersistable<Long>()