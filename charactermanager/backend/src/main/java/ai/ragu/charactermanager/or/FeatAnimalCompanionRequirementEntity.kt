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
    lateinit var featId: String

    @Column(name = "feat_category", nullable = true, length = -1)
    lateinit var featCategory: String

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val that = o as FeatAnimalCompanionRequirementEntity
        return featId == that.featId &&
                featCategory == that.featCategory
    }

    override fun hashCode(): Int {
        return Objects.hash(featId, featCategory)
    }
}