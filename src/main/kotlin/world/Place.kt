package world

class Place(val parent: Place?, val type: PlaceType) {



}

enum class PlaceType {
    City,
    Village
}