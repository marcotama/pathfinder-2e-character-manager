package ai.ragu.charactermanager.pojo

import AbstractJpaPersistable
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "language_category")
class LanguageCategory : AbstractJpaPersistable<Long>() {
    @Id
    @Column
    lateinit var id: String

    @Column
    lateinit var name: String
}