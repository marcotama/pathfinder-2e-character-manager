package ai.ragu.charactermanager.pojo

import AbstractJpaPersistable
import javax.persistence.Entity
import javax.persistence.ManyToOne

@Entity
class AncestryAbilityBoosts(
        @ManyToOne
        val ancestryId: String? = null,

        @ManyToOne
        val abilityScoreId: String? = null
) : AbstractJpaPersistable<Long>()