package bobby.irawan.roomflow

/**
 * Created by bobbyirawan09 on 06/08/20.
 */
data class Cat (
    var id: Int,
    var breed: String
) {
    companion object{
        fun from(catEntity: CatEntity) = Cat(
            catEntity.id,
            catEntity.breed
        )
    }
}