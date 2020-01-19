/**
 * The simplest type of user choice, where a value is chosen for a certain property.
 */
class Field {
    code: string;
    name: string;
    value: any;

    constructor(code: string, name: string, value: any) {
        this.code = code;
        this.name = name;
        this.value = value;
    }
}
/**
 * A set of fields that can be reused to represent a behaviour.
 * This can be used to group common structures in data, such as a stat having a score and a corresponding modifier, or
 * proficiency having a level that is one of untrained, trained, expert, master, or legendary.
 */
class Component {
    code: string;
    name: string;
    fields: Map<string, Field>;

    constructor(code: string, name: string) {
        this.code = code;
        this.name = name;
    }
}

/**
 * An item that has a set of characteristics.
 * This can be used to represent classes, races, weapons, etc.
 */
class Thing {
    code: string;
    name: string;
    components: Map<string, Component>;

    constructor(code: string, name: string) {
        this.code = code;
        this.name = name;
    }
}

/**
 * A more complex item, which has `Thing`s nested inside itself.
 */
class Entity {
    code: string;
    name: string;
    components: Map<string, Component>;
    things: Map<string, Thing>;

    constructor(code: string, name: string) {
        this.code = code;
        this.name = name;
    }
}

/**
 * A character to model.
 */
class Hero {
    code: string;
    name: string;
    components: Map<string, Component>;
    fields: Map<string, Field>;
    things: Map<string, Thing>;
    entities: Map<string, Entity>;

    constructor(code: string, name: string) {
        this.code = code;
        this.name = name;
    }
}