package ai.ragu.charactermanager.or

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "ancestry_ability_flaws", schema = "public", catalog = "charactermanager")
@IdClass(AncestryAbilityFlawsEntityPK::class)
class AncestryAbilityFlawsEntity {

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ancestry_id")
    lateinit var ancestry: AncestryEntity

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ability_score_id")
    lateinit var abilityScore: AbilityScoreEntity

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val that = other as AncestryAbilityFlawsEntity
        return ancestry == that.ancestry &&
                abilityScore == that.abilityScore
    }

    override fun hashCode(): Int {
        return Objects.hash(ancestry, abilityScore)
    }
}