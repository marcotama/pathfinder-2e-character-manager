package ai.ragu.charactermanager.pojo

import AbstractJpaPersistable
import javax.persistence.*

@Entity
@Table(name = "language")
class Language : AbstractJpaPersistable<Long>() {

    @Id
    @Column(nullable = false)
    lateinit var id: String

    @Column(nullable = false)
    lateinit var name: String

    @Column(nullable = false)
    lateinit var spokenBy: String

    @ManyToOne(cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", nullable = false)
    lateinit var category: LanguageCategory
}