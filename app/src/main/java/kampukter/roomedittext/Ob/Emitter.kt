package kampukter.roomedittext.Ob

class Emitter <T> {
    private val observers = mutableListOf<Observer<T>>()

    fun subscribe(observer: Observer<T>) {
        observers.add(observer)
    }

    fun emit(data: T) {
        observers.forEach { observer ->
            observer.onChanged(data)
        }
    }
}