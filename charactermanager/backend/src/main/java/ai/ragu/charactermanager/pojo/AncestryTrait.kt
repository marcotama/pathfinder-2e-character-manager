package ai.ragu.charactermanager.pojo

import AbstractJpaPersistable
import javax.persistence.*

@Entity
@Table(name = "ancestry_trait")
class AncestryTrait : AbstractJpaPersistable<Long>() {
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ancestry_id")
    lateinit var ancestry: Ancestry

    @Column
    lateinit var trait: String
}