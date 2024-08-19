import { Suspense, lazy } from 'react';
import './App.css';
import { DataProvider } from './Context/DataContext';
import { ErrorBoundary } from 'react-error-boundary';
import { MainApp } from './Home/Main';

function App() {
  return (
    <ErrorBoundary
      FallbackComponent={() => <div>Something went wrong</div>}
    >
      <Suspense fallback={<div>Loading...</div>}>
        <DataProvider>
          <MainApp />
        </DataProvider>
      </Suspense>
    </ErrorBoundary>
  )
}

export default App;
