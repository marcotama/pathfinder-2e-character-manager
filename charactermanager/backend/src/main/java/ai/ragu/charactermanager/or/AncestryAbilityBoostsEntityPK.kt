package ai.ragu.charactermanager.or

import java.io.Serializable
import java.util.*
import javax.persistence.Column
import javax.persistence.Id

class AncestryAbilityBoostsEntityPK : Serializable {

    @Id
    @Column(name = "ancestry_id", nullable = false, length = -1)
    lateinit var ancestryId: String

    @Id
    @Column(name = "ability_score_id", nullable = false, length = -1)
    lateinit var abilityScoreId: String

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val that = other as AncestryAbilityBoostsEntityPK
        return ancestryId == that.ancestryId &&
                abilityScoreId == that.abilityScoreId
    }

    override fun hashCode(): Int {
        return Objects.hash(ancestryId, abilityScoreId)
    }
}