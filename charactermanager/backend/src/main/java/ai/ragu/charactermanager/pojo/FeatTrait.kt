package ai.ragu.charactermanager.pojo

import AbstractJpaPersistable
import javax.persistence.*

@Entity
@Table(name = "feat_trait")
class FeatTrait : AbstractJpaPersistable<Long>() {

    @Column
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "feat_id")
    lateinit var feat: Feat

    @Column
    lateinit var trait: String
}