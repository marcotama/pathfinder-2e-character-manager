package ai.ragu.charactermanager.pojo

import AbstractJpaPersistable
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "alchemist_research_field")
class AlchemistResearchField : AbstractJpaPersistable<Long>() {
    @Id
    @Column
    lateinit var id: String

    @Column
    lateinit var name: String

    @Column
    lateinit var field: String

    @Column
    lateinit var infusions: String

    @Column
    lateinit var potency: String

    @Column
    lateinit var greaterField: String

    @Column
    lateinit var perfection: String
}