package ai.ragu.charactermanager.or

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "feat_animal_companion_requirement", schema = "public", catalog = "charactermanager")
class FeatAnimalCompanionRequirementEntity {
    @Column(name = "feat_id", nullable = false, length = -1)
    @Id
    lateinit var feat: String

    @Column(name = "feat_category", nullable = true, length = -1)
    lateinit var featCategory: String

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val that = other as FeatAnimalCompanionRequirementEntity
        return feat == that.feat &&
                featCategory == that.featCategory
    }

    override fun hashCode(): Int {
        return Objects.hash(feat, featCategory)
    }
}