function Sidebar () {
    return (
        <div className="bg-gray-800 text-white h-full w-48 flex flex-col">
            <div className="p-4 text-xl font-bold">Menu</div>
            <ul className="flex-1">
            <li className="p-4 hover:bg-gray-700 cursor-pointer">Opção 1</li>
            <li className="p-4 hover:bg-gray-700 cursor-pointer">Opção 2</li>
            <li className="p-4 hover:bg-gray-700 cursor-pointer">Opção 3</li>
      </ul>
    </div>
    )

}

export default Sidebar;