package ai.ragu.charactermanager.pojo

import AbstractJpaPersistable
import javax.persistence.*

@Entity
@Table(name = "spell_list")
class SpellList : AbstractJpaPersistable<Long>() {

    @Id
    @Column
    lateinit var id: String

    @Column
    lateinit var name: String

    @ManyToMany(
            cascade = [CascadeType.ALL],
            fetch = FetchType.EAGER
    )
    @JoinTable(
            name = "spell_list_item",
            joinColumns = [JoinColumn(name = "spell_list_id")],
            inverseJoinColumns = [JoinColumn(name = "spell_id")]
    )
    lateinit var spellLists: Set<SpellList>
}