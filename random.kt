// runs the code in the background thread pool
fun asyncOverlay() = async(CommonPool) {
// start two async operations
val original = asyncLoadImage("original")
val overlay = asyncLoadImage("overlay")
// and then apply overlay to both results
applyOverlay(original.await(), overlay.await())
}
// launches new coroutine in UI context
launch(UI) {
// wait for async overlay to complete
val image = asyncOverlay().await()
// and then show it in UI
showImage(image)
}
