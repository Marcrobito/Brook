package dev.eighteentech.brook

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.eighteentech.brook.entities.FitResult
import dev.eighteentech.brook.entities.FitResult.Loading
import dev.eighteentech.brook.entities.FitResult.NotLaunched
import dev.eighteentech.brook.entities.PressureMeasure
import dev.eighteentech.brook.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    private val _isPermissionGranted = MutableStateFlow(false)
    val isPermissionGranted: StateFlow<Boolean> get() = _isPermissionGranted

    private val _bloodPressureResults =
        MutableStateFlow<FitResult<List<PressureMeasure>>>(NotLaunched)
    val bloodPressureResult: StateFlow<FitResult<List<PressureMeasure>>> get() = _bloodPressureResults

    init {
        if (repository.oAuthPermissionsApproved()) {
            _isPermissionGranted.value = repository.oAuthPermissionsApproved()
            loadBloodPressureMeasures()
        }
    }

    private fun loadBloodPressureMeasures() {
        _bloodPressureResults.value = Loading
        viewModelScope.launch {
            _bloodPressureResults.value = withContext(Dispatchers.IO) {
                repository.readHistoryData()
            }
        }
    }


}