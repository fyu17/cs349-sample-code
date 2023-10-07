class Model {

    //region View Management

    // all views of this model
    private val views: ArrayList<IView> = ArrayList()

    // method that the views can use to register themselves with the Model
    // once added, they are told to update and get state from the Model
    fun addView(view: IView) {
        views.add(view)
        view.updateView()
    }

    fun removeView(view: IView?) {
        // remove view here
    }

    // the model uses this method to notify all of the Views that the data has changed
    // the expectation is that the Views will refresh themselves to display new data when appropriate
    private fun notifyObservers() {
        for (view in views) {
            println("Model: notify View")
            view.updateView()
        }
    }

    //endregion

    // simple accessor method to fetch the current state
    // of the data in the model, just a counter
    var counterValue = 0

    // method that the Controller uses to tell the Model to change state
    // in a larger application there would probably be multiple entry points like this
    fun incrementCounter() {
        counterValue++
        println("Model: increment counter to $counterValue")
        notifyObservers()
    }
}