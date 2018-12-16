package kampukter.roomedittext.Ob

interface Observer <in T> {
    fun onChanged(data: T)
}