package ai.ragu.charactermanager.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;

public interface AttackProficiencyEnum {
    @JsonCreator
    static AttackProficiencyEnum create(String str) {
        try {
            return MeleeWeaponTypeEnum.fromValue(str);
        } catch (Exception ignored) {}
        try {
            return RangedWeaponTypeEnum.fromValue(str);
        } catch (Exception ignored) {}
        try {
            return OtherAttackWeaponTypeEnum.fromValue(str);
        } catch (Exception ignored) {}
        throw new IllegalArgumentException(String.format("Unknown attack proficiency: %s", str));
    }
}
