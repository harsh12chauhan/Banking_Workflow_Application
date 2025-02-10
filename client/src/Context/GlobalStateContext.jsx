import { useState } from 'react'
import Context from './Context'

const GlobalStateContext = (props) => {

    const[userId,setUserId] = useState(0);

    return(
        <Context.Provider value={
            { 
             userId,setUserId
            }
        }>
            {props.children}
        </Context.Provider>
    )
}

export default GlobalStateContext