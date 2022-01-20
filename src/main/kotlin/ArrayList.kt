import kotlin.collections.ArrayList

class ArrayList() {
	private var array: Array<Int?> = Array(10) { null }

	var size = 0
	val isEmpty : Boolean
		get() = size == 0

	fun add(element: Int) {
		if (size == array.size) expandArr()
		array[size] = element
		size++
	}

	fun set(index: Int, element: Int) {
		if (index < 0 || index >= size) throw IndexOutOfBoundsException("Index $index out of bounds for length $size")
		else {
			if (size == array.size) expandArr()
			array[index] = element
		}
	}

	fun contains(element: Int): Boolean =
		element in array

	fun get(index: Int): Int {
		return if(index < 0 || index>=size) throw IndexOutOfBoundsException("Index $index out of bounds for length $size")
		else array[index]!!
	}

	fun indexOf(element: Int) =
		array.indexOf(element)

	fun lastIndexOf(element: Int) =
		array.lastIndexOf(element)

	fun toArray(): Array<Int>{
		val arr = Array(size){0}
		for(i in 0 until size){
			arr[i] = array[i]!!
		}
		return arr
	}

	private fun expandArr(){
		val buffer = array.copyOf()
		array = Array(size * 3 / 2) { null }
		buffer.forEachIndexed { newIndex, i ->  array[newIndex] = i}
	}
}