import React,{ useState} from 'react';
import { Link, useNavigate } from 'react-router-dom';
import axios from 'axios';

const Register = () => {

    const user = {
        "username": "",
        "email": "",
        "password": "",
        "cpassword": "",
        "phone": "",
        "address": "",
    };

    const [createUser, setCreateUser] = useState(user);
    const navigate = useNavigate();

    const { username, email, password, cpassword } = createUser;

    const CreateUserRequest = async () => {

        await axios.post('http://localhost:3000/user/register',{username,email,password})
        .then(res=>{
          console.log(res.status);
        })
        .catch(err=>console.log(err))
        console.log("register");
    }

    const handleSave = async () => {
        if (createUser.email !== "" && createUser.password !== "" && createUser.cpassword !== "") {
            if (createUser.password.length > 5 || createUser.cpassword.length > 5) {
                if (createUser.password === createUser.cpassword) {
                    await CreateUserRequest();
                    navigate('/')
                } else {
                    console.log("Password dont match");
                    setCreateUser(user);
                    setCreateUser(user);
                }
            } else {
                console.log("short password");
                setCreateUser(user);
                setCreateUser(user);
            }
        } else {
            if (createUser.email === "" && createUser.password === "" && createUser.cpassword === "") {
                console.log("Fill required credientials");
            } else {
                if (createUser.password === "") {
                    console.log("Fill password");
                }
                if (createUser.cpassword === "") {
                    console.log("Fill cpassword");
                }
                if (createUser.email === "") {
                    console.log("Fill Email");
                }
            }
        }
    }

    const handleChangeCreate = (e) => {
        setCreateUser({ ...createUser, [e.target.name]: e.target.value })
    }

    return (
        <div className="d-flex justify-content-center align-items-center" style={{ "height": "100vh" }}>
            <div className='border border-1 border-secondary p-5 rounded-3'>
                <h1 className='text-center fw-bold'>REGISTER</h1>
                <div className="my-4">
                    <input type="text" className="form-control" name='username' placeholder="User Name" aria-label="User Name" value={username} onChange={(e) => { handleChangeCreate(e) }} />
                </div>
                <div className="my-4">
                    <input type="email" className="form-control" name='email' placeholder="Email" aria-label="email" value={email} onChange={(e) => { handleChangeCreate(e) }} />
                </div>
                <div className="my-4">
                    <input type="password" className="form-control" name='password' placeholder="Password" aria-label="Password" value={password} onChange={(e) => { handleChangeCreate(e) }} />
                </div>
                <div className="my-4">
                    <input type="cpassword" className="form-control" name='cpassword' placeholder="Confirm Password" aria-label="cPassword" value={cpassword} onChange={(e) => { handleChangeCreate(e) }} />
                </div>
                <div className="my-4">
                    <button type="submit" className="btn btn-primary py-1 px-4 w-100" onClick={handleSave}>Register</button>
                </div>
                <div>
                    <p>Already have account? <a href='/'>login</a></p>
                </div>
            </div>
        </div>
    )
}

export default Register