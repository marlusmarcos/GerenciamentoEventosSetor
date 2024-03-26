import { Link } from 'react-router-dom'
import React, { ReactNode } from 'react';
interface HomeProps {
    children: ReactNode;
}


function Home({children} : HomeProps) {
    return (
        <div>
            <div className="bg-purple-800 text-white p-4 flex justify-between items-center">
                <div className="text-xl font-bold">Gerenciamento</div>
                <ul className="flex">
                    <li className="ml-4"><Link to="/" className="hover:text-gray-300">Início</Link></li>
                    <li className="ml-4"><Link to="/eventos" className="hover:text-gray-300">Cadastro</Link></li>
                    <li className="ml-4"><Link to="/sobre" className="hover:text-gray-300">Eventos</Link></li>
                </ul>
            </div>
            <div className="container mx-auto mt-8">
                {children} 
            </div>
        </div>
    );
   };
   
   export default Home;