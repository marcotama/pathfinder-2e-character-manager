package ai.ragu.charactermanager.or

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "alchemist_research_field", schema = "public", catalog = "charactermanager")
class AlchemistResearchFieldEntity {

    @Id
    @Column(name = "id", nullable = false, length = -1)
    lateinit var id: String

    @Column(name = "name", nullable = true, length = -1)
    lateinit var name: String

    @Column(name = "field", nullable = true, length = -1)
    lateinit var field: String

    @Column(name = "infusions", nullable = true, length = -1)
    lateinit var infusions: String

    @Column(name = "potency", nullable = true, length = -1)
    lateinit var potency: String

    @Column(name = "greater_field", nullable = true, length = -1)
    lateinit var greaterField: String

    @Column(name = "perfection", nullable = true, length = -1)
    lateinit var perfection: String

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val that = other as AlchemistResearchFieldEntity
        return id == that.id &&
                name == that.name &&
                field == that.field &&
                infusions == that.infusions &&
                potency == that.potency &&
                greaterField == that.greaterField &&
                perfection == that.perfection
    }

    override fun hashCode(): Int {
        return Objects.hash(id, name, field, infusions, potency, greaterField, perfection)
    }
}