import com.example.projectnew21.repository.DeckCardRepository
import com.example.projectnew21.repository.DeckCardRepositoryImpl
import com.example.projectnew21.useCases.DeckUseCase
import com.example.projectnew21.viewModel.GameViewModel
import com.example.projectnew21.viewModel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<DeckCardRepository> { DeckCardRepositoryImpl() }
    factory<DeckUseCase> { DeckUseCase(get()) }
    viewModel { MainViewModel(get()) }
    viewModel { GameViewModel(get()) }
}