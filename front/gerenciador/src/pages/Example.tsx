import { useState } from "react";


  interface Pessoa {
    id: number;
    name: string;
    email: string;
    image: string;
    pago: boolean;
  }

export default function Example(pessoa : Pessoa) {
    const [pessoas, setPessoas] = useState<Pessoa[]>([
        {
          id: 1,
          name: 'Calvin Hawkins',
          email: 'calvin.hawkins@example.com',
          image: 'https://images.unsplash.com/photo-1491528323818-fdd1faba62cc?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=facearea&facepad=2&w=256&h=256&q=80',
          pago: false
        },
        {
          id: 2,
          name: 'Kristen Ramos',
          email: 'kristen.ramos@example.com',
          image: 'https://images.unsplash.com/photo-1550525811-e5869dd03032?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=facearea&facepad=2&w=256&h=256&q=80',
          pago: true
        },
        {
          id: 3,
          name: 'Ted Fox',
          email: 'ted.fox@example.com',
          image: 'https://images.unsplash.com/photo-1500648767791-00dcc994a43e?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=facearea&facepad=2&w=256&h=256&q=80',
          pago: false
        },
      ]);
      const updatePagamento = (id: number) => {
        setPessoas(prevPessoas =>
          prevPessoas.map(pessoa =>
            pessoa.id === id ? { ...pessoa, pago: !pessoa.pago } : pessoa
          )
        );
      };
    return (
        <div >
            <ul className="divide-y divide-gray-200">
                {
                pessoas.map((pessoa) => (
                    <li key={pessoa.email} className="py-4 flex">
                        <img className="h-10 w-10 rounded-full" src={pessoa.image} alt="" />
                        <div className="ml-3">
                            <p className="text-sm font-medium text-gray-900">{pessoa.name}</p>
                            <p className="text-sm text-gray-500">{pessoa.email}</p>
                            <div>
                            <button onClick={() => updatePagamento(pessoa.id)} className={`ml-4 py-2 px-4 rounded ${pessoa.pago ? 'bg-green-500 hover:bg-green-600' : 'bg-red-500 hover:bg-red-600' } text-white`} >
                            {pessoa.pago ? 'Pago' : 'Não Pago'}
                            </button>
                            </div>
                            
                        </div>
                    </li>
                ))
                }
            </ul>
        </div>
      
    )
  }