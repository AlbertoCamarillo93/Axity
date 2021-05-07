from __future__ import annotations
from abc import ABC, abstractmethod


class Creator(ABC):
    """
    La clase Creator declara el método de fábrica que se supone que devuelve un
    objeto de una clase de producto. Las subclases del Creador generalmente proporcionan la
    implementación de este método.
    """

    @abstractmethod
    def factory_method(self):
        """
        Tenga en cuenta que el Creador también puede proporcionar alguna implementación 
        predeterminada de el método de fábrica.
        """
        pass

    def some_operation(self) -> str:
        """
        También tenga en cuenta que, a pesar de su nombre, la responsabilidad principal 
        del Creator no es crear productos. Por lo general, contiene cierta 
        lógica empresarial central que se basa en objetos Product, devueltos por el 
        método de fábrica. Las subclases pueden cambiar indirectamente esa lógica 
        empresarial anulando la método de fábrica y devolver un tipo de producto diferente.
        """

        # Llame al factory_method para crear un objeto product
        product = self.factory_method()

        # Ahora, usa el producto.
        result = f"Creator: The same creator's code has just worked with {product.operation()}"

        return result

"""
Concrete Creators anula el factory method para cambiar el resultado
tipo de producto.
"""
class ConcreteCreator1(Creator):
    """
    Tenga en cuenta que la firma del método todavía utiliza el tipo de producto abstracto,
    a pesar de que el producto concreto realmente se devuelve del método. Esto
    forma en que el Creador puede permanecer independiente de clases concretas de productos.
    """

    def factory_method(self) -> Product:
        return ConcreteProduct1()


class ConcreteCreator2(Creator):
    def factory_method(self) -> Product:
        return ConcreteProduct2()


class Product(ABC):
    """
    La interfaz de producto declara las operaciones que todos los concrete product 
    debe implementar.
    """

    @abstractmethod
    def operation(self) -> str:
        pass


"""
Concrete Products proporciona varias implementaciones de la interfaz del producto.
"""
class ConcreteProduct1(Product):
    def operation(self) -> str:
        return 'Logistica terrestre'

class ConcreteProduct2(Product):
    def operation(self) -> str:
        return 'Logistica marítima'

def client_code(creator: Creator) -> None:
    """
    El client_code funciona con una instancia de un ConcreteCreator, 
    aunque a través de su interfaz base. Siempre que el cliente siga trabajando 
    con el creador a través de la interfaz base, puedes pasarla a la subclase 
    de cualquier creador
    """

    print(f"Client: I'm not aware of the creator's class, but it still works.\n"
          f"{creator.some_operation()}", end="")


if __name__ == "__main__":
    print("App: Launched with the ConcreteCreator1.")
    client_code(ConcreteCreator1())
    print("\n")

    print("App: Launched with the ConcreteCreator2.")
    client_code(ConcreteCreator2())