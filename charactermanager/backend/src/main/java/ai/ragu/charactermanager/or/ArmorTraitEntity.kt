package ai.ragu.charactermanager.or

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "armor_trait", schema = "public", catalog = "charactermanager")
@IdClass(ArmorTraitEntityPK::class)
class ArmorTraitEntity {

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "armor_id")
    lateinit var armor: ArmorEntity

    @Id
    @Column(name = "trait", nullable = false, length = -1)
    lateinit var trait: String

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val that = other as ArmorTraitEntity
        return armor == that.armor &&
                trait == that.trait
    }

    override fun hashCode(): Int {
        return Objects.hash(armor, trait)
    }
}