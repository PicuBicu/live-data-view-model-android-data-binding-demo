
# Project description

This is a demo application for school presentation about live data, view model and android data binding.
It can help you start easily with these subjects.

Application uses Random Data Api that fetches random beer data. Beer data is stored using MutableLiveData inside ViewModel class.
Each activity / fragment can subscribe to LiveData change using observe function and then update it's UI in it.

View model data such as Beer Model or error message from Api are then bind to xml activity file so programmer do not have to use findViewById in activity to for example set values of TextView.

