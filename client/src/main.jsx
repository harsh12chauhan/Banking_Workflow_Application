import { createRoot } from 'react-dom/client'
import './index.css'
import App from './App.jsx'
import 'bootstrap/dist/css/bootstrap.css';
import GlobalStateContext from './Context/GlobalStateContext.jsx';

createRoot(document.getElementById('root')).render(
  <GlobalStateContext>
    <App />
  </GlobalStateContext>
)
