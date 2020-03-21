package ai.ragu.charactermanager.pojo

import AbstractJpaPersistable
import javax.persistence.*

@Entity
@Table(name = "background")
class Background : AbstractJpaPersistable<Long>() {

    @Column
    lateinit var id: String

    @Column
    lateinit var name: String

    @Column
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "boost_ref_1")
    lateinit var boostRef1: AbilityScore

    @Column
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "boost_ref_2")
    lateinit var boostRef2: AbilityScore

    @Column
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "free_feat_id")
    lateinit var freeFeatId: Feat

    @Column
    lateinit var freeFeatDetail: String

    @Column
    lateinit var lore: String

    @Column
    lateinit var skill: String

    @Column
    lateinit var description: String

    @Column
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "src")
    lateinit var src: RulesSource

    @Column
    lateinit var url: String
}