package ai.ragu.charactermanager.pojo

import AbstractJpaPersistable
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Ancestry(
        @Id
        @Column(nullable = false)
        val id: String? = null,

        @Column(nullable = false)
        val name: String? = null,

        @Column(nullable = false)
        val baseHitPoints: Long = 0,

        @Column(nullable = false)
        val numFreeAbilityBoosts: Long = 0,

        @Column(nullable = false)
        val ancestryFeatLevels: Long = 0,

        @Column(nullable = false)
        val description: String? = null,

        @Column(nullable = false)
        val numFreeLanguages: Long = 0,

        @Column(nullable = false)
        val size: String? = null,

        @Column(nullable = false)
        val speed: Long = 0,

        @Column(nullable = false)
        val src: String? = null,

        @Column(nullable = false)
        val url: String? = null
) : AbstractJpaPersistable<Long>()