class Target:
    """
    The Target defines the domain-specific interface used by the client code.
    """

    def request(self) -> str:
        return "Les dije que no esperen nada de mi."


class Adaptee:
    """
    The Adaptee contains some useful behavior, but its interface is incompatible
    with the existing client code. The Adaptee needs some adaptation before the
    client code can use it.
    """

    def specific_request(self) -> str:
        return ".anita lava la tinA"


class Adapter(Target, Adaptee):
    """
    The Adapter makes the Adaptee's interface compatible with the Target's
    interface via multiple inheritance.
    """

    def request(self) -> str:
        return f"{self.specific_request()[::-1]}"


def client_code(target: "Target") -> None:
    """
    The client code supports all classes that follow the Target interface.
    """

    print(target.request(), end="")


if __name__ == "__main__":
    print("Persona: Yo estoy aprediendo a hacer palindromonos, no esperen nada de mi ")
    target = Target()
    client_code(target)
    print("\n")

    adaptee = Adaptee()
    print("Persona: Ahi les va un tremendo palíndromo. "
          "Checa nomás:")
    print(f"El palíndromo: {adaptee.specific_request()}", end="\n\n")

    print("Persona: y ahora de forma normal:")
    adapter = Adapter()
    client_code(adapter)