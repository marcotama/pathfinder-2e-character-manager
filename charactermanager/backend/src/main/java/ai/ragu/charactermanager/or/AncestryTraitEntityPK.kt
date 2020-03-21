package ai.ragu.charactermanager.or

import java.io.Serializable
import java.util.*
import javax.persistence.*

class AncestryTraitEntityPK : Serializable {

    @Id
    @Column(name = "ancestry_id", nullable = false, length = -1)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ancestry_id")
    lateinit var ancestry: AncestryEntity

    @Id
    @Column(name = "trait", nullable = false, length = -1)
    lateinit var trait: String

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val that = other as AncestryTraitEntityPK
        return ancestry == that.ancestry &&
                trait == that.trait
    }

    override fun hashCode(): Int {
        return Objects.hash(ancestry, trait)
    }
}