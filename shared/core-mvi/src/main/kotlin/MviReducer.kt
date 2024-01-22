import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class MviReducer<Event : UiEvent, State : UiState, Effect : UiEffect>(
    private val viewModelScope: CoroutineScope,
    private val handleEvent: (Event) -> Unit,
    initialState: State
) {
    private val _stateFlow = MutableStateFlow(initialState)
    val stateFlow = _stateFlow.asStateFlow()

    private val _eventFlow = MutableSharedFlow<Event>()

    private val _effectFlow = Channel<Effect>()
    val effectFlow = _effectFlow.receiveAsFlow()

    init {
        handleEvent()
    }

    private fun handleEvent() {
        _eventFlow
            .onEach { event -> handleEvent(event) }
            .launchIn(viewModelScope)
    }

    fun setState(reduce: suspend State.() -> State) {
        viewModelScope.launch {
            _stateFlow.emit(_stateFlow.value.reduce())
        }
    }

    fun setEvent(event: Event) {
        viewModelScope.launch {
            _eventFlow.emit(event)
        }
    }
}