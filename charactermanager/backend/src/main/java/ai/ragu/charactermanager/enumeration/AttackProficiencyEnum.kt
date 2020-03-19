package ai.ragu.charactermanager.enumeration

import com.fasterxml.jackson.annotation.JsonCreator

interface AttackProficiencyEnum {
    companion object {
        @JsonCreator
        fun create(str: String?): AttackProficiencyEnum? {
            try {
                return MeleeWeaponTypeEnum.Companion.fromValue(str)
            } catch (ignored: Exception) {
            }
            try {
                return RangedWeaponTypeEnum.Companion.fromValue(str)
            } catch (ignored: Exception) {
            }
            try {
                return OtherAttackWeaponTypeEnum.Companion.fromValue(str)
            } catch (ignored: Exception) {
            }
            throw IllegalArgumentException(String.format("Unknown attack proficiency: %s", str))
        }
    }
}