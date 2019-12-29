from dataclasses import dataclass
from typing import *

@dataclass
class Field:
    """
    The simplest type of user choice, where a value is chosen for a certain property.
    """
    code: str
    name: str
    type: Union[type, enumerate]
    value: Any

@dataclass
class Component:
    """
    A set of fields that can be reused to represent a behaviour.
    This can be used to group common structures in data, such as a stat having a score and a corresponding modifier, or
    proficiency having a level that is one of untrained, trained, expert, master, or legendary.
    """
    code: str
    name: str
    fields: Dict[str, Field]

@dataclass
class Thing:
    """
    An item that has a set of characteristics.
    This can be used to represent classes, races, weapons, etc.
    """
    code: str
    name: str
    components: Dict[str, Component]

@dataclass
class Entity:
    """
    A more complex item, which has `Thing`s nested inside itself.
    """
    code: str
    name: str
    components: Dict[str, Component]
    things: Dict[str, Thing]

@dataclass
class Hero:
    """
    A character to model.
    """
    code: str
    name: str
    components: Dict[str, Component]
    fields: Dict[str, Field]
    things: Dict[str, Thing]
    entities: Dict[str, Entity]